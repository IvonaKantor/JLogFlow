const API = '/api';

async function loadStats() {
    try {
        const response = await fetch(`${API}/stats`);
        const stats = await response.json();

        document.getElementById('statsContent').innerHTML = `
            <p>Total Logs: ${stats.total || 0}</p>
            <p>Errors: ${stats.errors || 0}</p>
            <p>Warnings: ${stats.warnings || 0}</p>
            <p>Infos: ${stats.infos || 0}</p>
            <p>Services: ${stats.services || 0}</p>
        `;
    } catch (error) {
        document.getElementById('statsContent').innerHTML = 'Error loading stats';
    }
}

async function loadLogs() {
    try {
        const response = await fetch(`${API}/dashboard/recent`);
        const logs = await response.json();

        document.getElementById('logsContent').innerHTML = logs.map(log => `
            <div class="log-entry log-${log.level?.toLowerCase() || 'info'}">
                <strong>${log.level}</strong> - ${log.serviceName} - ${log.timestamp}
                ${log.sourceIp ? `<br>IP: ${log.sourceIp}` : ''}
                ${log.httpMethod ? `<br>${log.httpMethod} ${log.httpStatus || ''}` : ''}
                <br>${log.message}
            </div>
        `).join('');
    } catch (error) {
        document.getElementById('logsContent').innerHTML = 'Error loading logs';
    }
}

async function searchLogs() {
    const query = document.getElementById('searchInput').value;
    try {
        const response = await fetch(`${API}/dashboard/search?q=${encodeURIComponent(query)}`);
        const logs = await response.json();

        document.getElementById('logsContent').innerHTML = logs.map(log => `
            <div class="log-entry log-${log.level?.toLowerCase() || 'info'}">
                <strong>${log.level}</strong> - ${log.serviceName} - ${log.timestamp}
                ${log.sourceIp ? `<br>IP: ${log.sourceIp}` : ''}
                ${log.httpMethod ? `<br>${log.httpMethod} ${log.httpStatus || ''}` : ''}
                <br>${log.message}
            </div>
        `).join('');
    } catch (error) {
        document.getElementById('logsContent').innerHTML = 'Error searching logs';
    }
}

document.addEventListener('DOMContentLoaded', function() {
    loadStats();
    loadLogs();
});
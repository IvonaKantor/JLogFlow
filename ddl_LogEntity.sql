CREATE TABLE data
(
    id           BIGINT                      NOT NULL,
    logId        VARCHAR(255)                NOT NULL,
    level        VARCHAR(20)                 NOT NULL,
    message      TEXT,
    serviceName  VARCHAR(255)                NOT NULL,
    timestamp    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    sourceIp     VARCHAR(50),
    userId       VARCHAR(100),
    responseTime BIGINT,
    httpMethod   VARCHAR(10),
    httpStatus   INTEGER
);

CREATE TABLE metadata
(
    log_id         BIGINT       NOT NULL,
    metadata_value VARCHAR(255),
    metadata_key   VARCHAR(255) NOT NULL
);

ALTER TABLE data
    ADD CONSTRAINT uc_logdata_logid UNIQUE (logId);

CREATE INDEX idx_logs_level ON data (level);

CREATE INDEX idx_logs_service ON data (serviceName);

CREATE INDEX idx_logs_timestamp ON data (timestamp);

CREATE INDEX idx_logs_timestamp_level ON data (timestamp, level);

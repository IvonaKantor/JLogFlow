CREATE TABLE services
(
    id           INT PRIMARY KEY,
    service_name VARCHAR(255) NOT NULL,
    service_id   VARCHAR(255),
    description  VARCHAR(255),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (service_name, service_id)
);

CREATE TABLE hosts
(
    id          INT PRIMARY KEY,
    host_name   VARCHAR(255) NOT NULL UNIQUE,
    ip_address  VARCHAR(255),
    environment VARCHAR(255),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE processes
(
    id           INT PRIMARY KEY,
    process_name VARCHAR(255) NOT NULL,
    process_id   INTEGER      NOT NULL,
    host_id      INTEGER      REFERENCES hosts (id) ON DELETE SET NULL,
    start_time   TIMESTAMP,
    UNIQUE (process_name, process_id, host_id)
);

CREATE TABLE loggers
(
    id                INT PRIMARY KEY,
    logger_name       VARCHAR(255) NOT NULL UNIQUE,
    logger_class_name VARCHAR(255),
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE logs
(
    id           INT PRIMARY KEY,
    uuid         VARCHAR(255),
    service_id   INTEGER REFERENCES services (id) ON DELETE CASCADE,
    host_id      INTEGER      REFERENCES hosts (id) ON DELETE SET NULL,
    process_id   INTEGER      REFERENCES processes (id) ON DELETE SET NULL,
    logger_id    INTEGER      REFERENCES loggers (id) ON DELETE SET NULL,
    timestamp    TIMESTAMP    NOT NULL,
    sequence     INTEGER      DEFAULT 0,
    level        VARCHAR(20)  NOT NULL CHECK (level IN ('DEBUG', 'INFO', 'WARN', 'ERROR')),
    message      VARCHAR(255) NOT NULL,
    thread_name  VARCHAR(255),
    thread_id    INT,
    mdc          JSON,
    ndc          VARCHAR(255),
    exception_id INT,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE exceptions
(
    id                INT PRIMARY KEY,
    ref_id            INT,
    exception_type    VARCHAR(255) NOT NULL,
    exception_message VARCHAR(255),
    root_cause        VARCHAR(255),
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE exception_frames
(
    id           INT PRIMARY KEY,
    exception_id INT          NOT NULL REFERENCES exceptions (id) ON DELETE CASCADE,
    frame_order  INTEGER      NOT NULL,
    class_name   VARCHAR(255) NOT NULL,
    method_name  VARCHAR(255) NOT NULL,
    line_number  INT,
    file_name    VARCHAR(255),
    is_native    BOOLEAN DEFAULT FALSE,

    UNIQUE (exception_id, frame_order)
);

CREATE TABLE log_statistics
(
    id           INT PRIMARY KEY,
    service_id   INT REFERENCES services (id),
    log_date     DATE        NOT NULL,
    hour         INT    NOT NULL CHECK (hour >= 0 AND hour <= 23),
    level        VARCHAR(20) NOT NULL,
    log_count    INT  DEFAULT 0,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    UNIQUE (service_id, log_date, hour, level)
);
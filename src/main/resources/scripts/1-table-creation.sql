CREATE TABLE USERS (
    ID                  VARCHAR2(256 BYTE) PRIMARY KEY,
    FIRST_NAME          VARCHAR2(256 BYTE) NOT NULL,
    LAST_NAME           VARCHAR2(256 BYTE) NOT NULL,
    EMAIL               VARCHAR2(256 BYTE) NOT NULL UNIQUE,
    ACCESS_TOKEN        VARCHAR2(256 BYTE) NOT NULL UNIQUE,
    MARKETING_CONSENT   NUMBER(1,0) DEFAULT 0 NOT NULL
)
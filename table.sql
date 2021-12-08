CREATE TABLE AHPATIENT
(
	PATIENTID NUMBER(19,0) NOT NULL,
	IDENTIFICATIONNO VARCHAR2(20) NOT NULL,
	PATIENTNO VARCHAR2(20) NOT NULL,
	FIRSTNAME VARCHAR2(64), 
	LASTNAME VARCHAR2(64),
	BIRTHDATE DATE,
	MARITALSTATUS VARCHAR2(10),
	BLOODGROUP VARCHAR2(10),
	GENDER VARCHAR2(10),
	STATUS VARCHAR2(1),
	CONSTRAINT AHPATIENT_PK PRIMARY KEY (PATIENTID)
);
 

CREATE TABLE AHORGANIZATION
(
	ORGANIZATIONID NUMBER(19,0) NOT NULL,
	NAME VARCHAR2(64), 
	CODE VARCHAR2(64),
	ACTIVE VARCHAR2(1),
	STATUS VARCHAR2(1),
	CONSTRAINT AHORGANIZATION_PK PRIMARY KEY (ORGANIZATIONID)
);


CREATE TABLE AHSTAFFTYPE
(
	STAFFTYPEID NUMBER(19,0) NOT NULL,
	CODE VARCHAR2(64),
	NAME VARCHAR2(64),
	STAFFTYPE VARCHAR(2),
	STATUS VARCHAR2(1),
	CONSTRAINT AHSTAFFTYPE_PK PRIMARY KEY (STAFFTYPEID)
);



CREATE TABLE AHSTAFF
(
	STAFFID NUMBER(19,0) NOT NULL,
	NAME VARCHAR2(64),
	SURNAME VARCHAR2(64),
	IDENTIFICATIONNO VARCHAR2(20),
	BIRTHDATE DATE,
	BIRTHPLACE DATE,
	GENDER VARCHAR2(10),
    ORGANIZATIONID NUMBER(19,0),
	STAFFTYPEID NUMBER(19,0),
	MARITALSTATUS VARCHAR2(10),
	BLOODGROUP VARCHAR2(10),
	MOBILEPHONE VARCHAR2(20),
	WORKPHONE VARCHAR2(20),
	MILITARYSTATUS VARCHAR2(20),
	STATUS VARCHAR2(1),
	CONSTRAINT AHSTAFF_PK PRIMARY KEY (STAFFID)
);



CREATE TABLE AHCODEDEFINITION
(
	CODEDEFINITIONID NUMBER(19,0) NOT NULL,
	CODEDEFINITION VARCHAR2(64),
	DESCRIPTION VARCHAR2(64),
	STATUS VARCHAR2(1),
	CONSTRAINT AHCODEDEFINITION_PK PRIMARY KEY (CODEDEFINITIONID),
	CONSTRAINT AHCODEDEFINITION_UQ UNIQUE (CODEDEFINITION)
);


  CREATE TABLE AHCODEVALUE
(
	CODEVALUEID NUMBER(19,0) NOT NULL,
	CODEDEFINITIONID VARCHAR2(64) NOT NULL,
	CODE VARCHAR2(20),
	DISPLAYVALUE VARCHAR2(64),
	DESCRIPTION VARCHAR2(64),
	ACTIVE VARCHAR2(1),
	STATUS VARCHAR2(1),
	CONSTRAINT AHCODEVALUE_PK PRIMARY KEY (CODEVALUEID)
);


CREATE TABLE client ( 
  id BIGINT NOT NULL, 
  salesforce_id VARCHAR(18) NOT NULL, -- FK to Salesforce Account object 
  jive_space_id BIGINT NOT NULL, -- Jive container id 
  practice VARCHAR(50), 
  potential VARCHAR(20), 
  stage VARCHAR(20), 
  pace VARCHAR(20), 
  PRIMARY KEY (id) 
);

CREATE TABLE meeting_note ( 
  id BIGINT NOT NULL, 
  client_id BIGINT NOT NULL, -- FK to client table 
  title VARCHAR(255) NOT NULL, 
  jive_document_id BIGINT NOT NULL, 
  meeting_date BIGINT NOT NULL, -- java date as millis 
  public_note TEXT, 
  private_note TEXT, 
  meeting_type VARCHAR(50), 
  PRIMARY KEY (id) 
); 
ALTER TABLE meeting_note ADD CONSTRAINT client_id_fk FOREIGN KEY (client_id) REFERENCES client ON 
DELETE CASCADE;

CREATE TABLE email_log ( 
  id BIGINT NOT NULL, 
  meeting_note_id BIGINT NOT NULL, -- FK to meeting_note table 
  date_sent BIGINT NOT NULL, -- java date as millis 
  recipient_list TEXT, -- delimited list of email addresses 
  html_body TEXT, 
PRIMARY KEY (id) 
); 
ALTER TABLE email_log ADD CONSTRAINT meeting_note_id_fk FOREIGN KEY (meeting_note_id) REFERENCES 
meeting_note ON DELETE CASCADE;

CREATE TABLE advisor_attendee ( 
  id BIGINT NOT NULL, 
  meeting_note_id BIGINT NOT NULL, -- FK to meeting_note table 
  jive_user_id BIGINT NOT NULL, -- Jive user id 
  durationHours NUMERIC, -- number of hours 
  PRIMARY KEY (id) 
 );
 ALTER TABLE advisor_attendee ADD CONSTRAINT meeting_note_id_fk FOREIGN KEY (meeting_note_id) 
REFERENCES meeting_note ON DELETE CASCADE; 

CREATE TABLE client_attendee ( 
  id BIGINT NOT NULL, 
  meeting_note_id BIGINT NOT NULL, -- FK to meeting_note table 
  client_contact_id VARCHAR(18) NOT NULL, -- user id 
  durationHours NUMERIC, -- number of hours 
  PRIMARY KEY (id) 
); 
ALTER TABLE client_attendee ADD CONSTRAINT meeting_note_id_fk FOREIGN KEY (meeting_note_id) 
REFERENCES meeting_note ON DELETE CASCADE; 

CREATE TABLE service_provider ( 
  id BIGINT NOT NULL, 
  provider_type VARCHAR(50), 
  provider_name VARCHAR(255), 
  provider_email VARCHAR(255), 
  binary_attachment BYTEA, 
  attachment_mime_type VARCHAR(255), 
  PRIMARY KEY (id) 
); 

CREATE TABLE referral ( 
  id BIGINT NOT NULL, 
  meeting_note_id BIGINT NOT NULL, 
  is_advisor BOOLEAN, 
  service_provider_id BIGINT, -- FK to service_provider table  
  internal_user_id BIGINT, 
  PRIMARY KEY (id) 
); 
ALTER TABLE referral ADD CONSTRAINT meeting_note_id_fk FOREIGN KEY (meeting_note_id) REFERENCES 
meeting_note ON DELETE CASCADE; 

CREATE TABLE advisory_team_member ( 
  id BIGINT NOT NULL, 
  client_id BIGINT NOT NULL, 
  advisor_user_id VARCHAR(255) NOT NULL, 
  is_lead BOOLEAN,  
  PRIMARY KEY (id) 
); 
ALTER TABLE advisory_team_member ADD CONSTRAINT client_id_fk FOREIGN KEY (client_id) REFERENCES 
client ON DELETE CASCADE; 

CREATE TABLE resource ( 
  id BIGINT NOT NULL, 
type VARCHAR(50), 
  title VARCHAR(255) NOT NULL, 
  display_html_body TEXT NOT NULL, 
  mail_html_body TEXT NOT NULL,  
  PRIMARY KEY (id) 
);

CREATE TABLE recommended_resource ( 
  id BIGINT NOT NULL, 
  meeting_note_id BIGINT NOT NULL, 
  resource_id BIGINT NOT NULL, 
  PRIMARY KEY (id) 
); 
ALTER TABLE recommended_resource ADD CONSTRAINT meeting_note_id_fk FOREIGN KEY (meeting_note_id) 
REFERENCES meeting_note ON DELETE CASCADE; 
ALTER TABLE recommended_resource ADD CONSTRAINT resource_id_fk FOREIGN KEY (resource_id) 
REFERENCES meeting_note; 

CREATE TABLE resource_tag ( 
  id BIGINT NOT NULL, 
  resource_id BIGINT NOT NULL, 
  tag_name VARCHAR(255), 
  PRIMARY KEY (id) 
); 
ALTER TABLE resource_tag ADD CONSTRAINT resource_id_fk FOREIGN KEY (resource_id) REFERENCES 
resource; 
CREATE INDEX ON resource_tag (tag_name); 

CREATE TABLE milestone ( 
  id BIGINT NOT NULL, 
  category VARCHAR(255), 
  name VARCHAR(255) NOT NULL, 
description VARCHAR(255), 
valueType VARCHAR(50) NOT NULL, 
  PRIMARY KEY (id) 
);


CREATE TABLE client_milestone ( 
  id BIGINT NOT NULL, 
  client_id VARCHAR(18) NOT NULL, -- fk to the client in Salesforce 
  milestone_id BIGINT NOT NULL, -- fk to the milestone table 
date BIGINT NOT NULL, 
value VARCHAR(255) NOT NULL, 
  PRIMARY KEY (id) 
); 
ALTER TABLE client_milestone ADD CONSTRAINT milestone_id_fk FOREIGN KEY (milestone_id) REFERENCES 
milestone ON DELETE CASCADE; 
 


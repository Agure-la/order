CREATE TABLE if not exists Users
(
   UserId      BIGINT    AUtO_INCREMENT      NOT NULL,
   FirstName   VARCHAR                       NULL,
   LastName    VARCHAR                       NULL,
   MobileNo    VARCHAR                       NULL,
   Password    VARCHAR                       NULL,
   Email       VARCHAR                       NULL,
   CONSTRAINT  pk_id PRIMARY KEY(UserId),
   CONSTRAINT  MobileNo  UNIQUE(MobileNo),
   CONSTRAINT  Password  UNIQUE(Password),
   CONSTRAINT  Email     UNIQUE(Email)
);

CREATE TABLE IF NOT EXISTS user_roles
(
    id         BIGINT AUtO_INCREMENT        NOT NULL,
    role_name  VARCHAR                      NULL,
    CONSTRAINT pk_id PRIMARY KEY(id),
    CONSTRAINT name  UNIQUE(role_name)
);

CREATE TABLE IF NOT EXISTS user_user_roles
(
  role_id      BIGINT NOT NULL,
  user_id      BIGINT NOT NULL,
  FOREIGN KEY (user_id)  REFERENCES  Users(id) ON DELETE CASCADE,
  FOREIGN KEY (role_id)  REFERENCES  user_roles(id) ON DELETE CASCADE,
  CONSTRAINT user_to_role_cx UNIQUE(user_id, role_id)
);


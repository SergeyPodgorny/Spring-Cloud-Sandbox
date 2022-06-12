CREATE TABLE bills (bill_id bigint PRIMARY KEY NOT NULL,
                    account_id bigint NOT NULL,
                    amount numeric(19,2) NOT NULL,
                    is_default boolean NOT NULL,
                    creation_date timestamp NOT NULL,
                    overdraft_enabled boolean NOT NULL);
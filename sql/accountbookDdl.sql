CREATE TABLE `member`
(
    `member_no`          BIGINT NOT NULL comment 'id',
    `member_email`       VARCHAR(100) NOT NULL comment '회원 이메일',
    `member_password`    VARCHAR(200) NOT NULL comment '회원 비밀번호',
    `member_name`        VARCHAR(50) NOT NULL comment '회원이름',
    `member_signup_date` TIMESTAMP NOT NULL comment '가입일',
    `created_dt`         TIMESTAMP NULL comment '생성날짜',
    `modified_dt`        TIMESTAMP NULL comment '수정날짜'
);

CREATE TABLE `accout_book_detail`
(
    `account_book_detail_no` BIGINT NOT NULL comment 'id',
    `account_book_no`        BIGINT NOT NULL comment 'id',
    `place`                  VARCHAR(255) NULL comment '사용처',
    `amount`                 BIGINT NOT NULL comment '금액',
    `transaction_date`       TIMESTAMP NOT NULL comment '금액사용날짜 및 시간',
    `transaction_type`       VARCHAR(10) NOT NULL comment '수입,지출',
    `memo`                   VARCHAR(255) NULL comment '메모',
    `delete_yn`              VARCHAR(1) NOT NULL DEFAULT n comment '삭제여부',
    `created_dt`             TIMESTAMP NULL comment '생성날짜',
    `modified_dt`            TIMESTAMP NULL comment '수정날짜'
);

CREATE TABLE `account_book`
(
    `account_book_no`   BIGINT NOT NULL comment 'id',
    `member_no`         BIGINT NOT NULL comment 'id',
    `account_book_name` VARCHAR(50) NOT NULL comment '가계부명',
    `delete_yn`         VARCHAR(1) NOT NULL DEFAULT n comment '삭제여부',
    `memo`              VARCHAR(255) NULL comment '메모',
    `created_dt`        TIMESTAMP NOT NULL comment '생성날짜',
    `modified_dt`       TIMESTAMP NULL comment '수정날짜'
);

ALTER TABLE `member`
    ADD CONSTRAINT `pk_member` PRIMARY KEY ( `member_no` );

ALTER TABLE `accout_book_detail`
    ADD CONSTRAINT `pk_accout_book_detail` PRIMARY KEY ( `account_book_detail_no`,
                                                         `account_book_no` );

ALTER TABLE `account_book`
    ADD CONSTRAINT `pk_account_book` PRIMARY KEY ( `account_book_no`, `member_no` );

ALTER TABLE `accout_book_detail`
    ADD CONSTRAINT `fk_account_book_to_accout_book_detail_1` FOREIGN KEY (`account_book_no` ) REFERENCES `account_book` ( `account_book_no` );

ALTER TABLE `account_book`
    ADD CONSTRAINT `fk_member_to_account_book_1` FOREIGN KEY ( `member_no` )
        REFERENCES `member` ( `member_no` );
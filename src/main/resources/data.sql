/* MEMBER PWD : qwer1234 */
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'admin00@benggri.com'  , 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'admin01@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'admin02@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'admin03@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'admin04@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'admin05@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'member00@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'member01@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'member02@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'member03@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'member04@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())
INSERT INTO MEMBER(IDX, EMAIL, NICKNAME, PASSWORD, MEMBER_TYPE, JOIN_DATE, REQ_DATE, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MEMBER_IDX'), 'member05@benggri.com', 'admin', '$2a$10$Gfee.MhqJ.aAsHyMCVYZ.OlrfwDNzuVDn2bWqHYftDlvwhB6Ko9aa', 'ADMIN', now(), now(), now(), now())

INSERT INTO MENU(IDX, MENU_ID, MENU_NAME, MENU_DESC, PARENT_MENU_ID, MENU_SORT_BY, MENU_AUTH, MENU_URL, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MENU_IDX'), 'BOARD', '게시판', '게시판', null, 1, 'ALL', '/board', now(), now())
INSERT INTO MENU(IDX, MENU_ID, MENU_NAME, MENU_DESC, PARENT_MENU_ID, MENU_SORT_BY, MENU_AUTH, MENU_URL, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MENU_IDX'), 'BOARD_FREE', '게시판', '게시판', 'BOARD', 1, 'ALL', '/board/free', now(), now())
INSERT INTO MENU(IDX, MENU_ID, MENU_NAME, MENU_DESC, PARENT_MENU_ID, MENU_SORT_BY, MENU_AUTH, MENU_URL, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MENU_IDX'), 'BOARD_DEVELOP', '개발공부', '개발공부', 'BOARD', 2, 'LOGIN_MEMBER', '/board/develop', now(), now())
INSERT INTO MENU(IDX, MENU_ID, MENU_NAME, MENU_DESC, PARENT_MENU_ID, MENU_SORT_BY, MENU_AUTH, MENU_URL, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MENU_IDX'), 'HELP', '고객지원', '고객지원', null, 1, 'ALL', '/help', now(), now())
INSERT INTO MENU(IDX, MENU_ID, MENU_NAME, MENU_DESC, PARENT_MENU_ID, MENU_SORT_BY, MENU_AUTH, MENU_URL, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MENU_IDX'), 'HELP_FAQ', 'FAQ', 'FAQ', 'HELP', 1, 'ALL', '/help/faq', now(), now())
INSERT INTO MENU(IDX, MENU_ID, MENU_NAME, MENU_DESC, PARENT_MENU_ID, MENU_SORT_BY, MENU_AUTH, MENU_URL, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('MENU_IDX'), 'HELP_QUESTION', '문의하기', '문의하기', 'HELP', 2, 'LOGIN_MEMBER', '/help/question', now(), now())

INSERT INTO BOARD(IDX, BOARD_NAME, BOARD_DESC, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('BOARD_IDX'), '자유게시판', '자유게시판', now(), now())
INSERT INTO BOARD(IDX, BOARD_NAME, BOARD_DESC, CM_REG_DTM, CM_UPD_DTM) VALUES (nextval('BOARD_IDX'), '개발공부', '개발공부', now(), now())

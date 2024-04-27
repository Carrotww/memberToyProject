INSERT INTO MEMBERS (
  member_login_id,
  password,
  nickname,
  member_name,
  phone_number,
  email,
  created_at,
  last_modified_at
) VALUES
('user1', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick1', 'A', '010-0001-0001', 'user1@example.com', NOW(), NOW()),
('user2', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick2', 'AA', '010-0002-0002', 'user2@example.com', DATEADD('MINUTE', 1, NOW()), DATEADD('MINUTE', 1, NOW())),
('user3', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick3', 'AAA', '010-0003-0003', 'user3@example.com', DATEADD('MINUTE', 2, NOW()), DATEADD('MINUTE', 2, NOW())),
('user4', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick4', 'AB', '010-0004-0004', 'user4@example.com', DATEADD('MINUTE', 3, NOW()), DATEADD('MINUTE', 3, NOW())),
('user5', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick5', 'ABA', '010-0005-0005', 'user5@example.com', DATEADD('MINUTE', 4, NOW()), DATEADD('MINUTE', 4, NOW())),
('user6', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick6', 'ABB', '010-0006-0006', 'user6@example.com', DATEADD('MINUTE', 5, NOW()), DATEADD('MINUTE', 5, NOW())),
('user7', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick7', 'ABBA', '010-0007-0007', 'user7@example.com', DATEADD('MINUTE', 6, NOW()), DATEADD('MINUTE', 6, NOW())),
('user8', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick8', 'B', '010-0008-0008', 'user8@example.com', DATEADD('MINUTE', 7, NOW()), DATEADD('MINUTE', 7, NOW())),
('user9', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick9', 'BA', '010-0009-0009', 'user9@example.com', DATEADD('MINUTE', 8, NOW()), DATEADD('MINUTE', 8, NOW())),
('user10', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick10', 'BAA', '010-0010-0010', 'user10@example.com', DATEADD('MINUTE', 9, NOW()), DATEADD('MINUTE', 9, NOW())),
('user11', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick11', 'BB', '010-0011-0011', 'user11@example.com', DATEADD('MINUTE', 10, NOW()), DATEADD('MINUTE', 10, NOW())),
('user12', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick12', 'BBA', '010-0012-0012', 'user12@example.com', DATEADD('MINUTE', 11, NOW()), DATEADD('MINUTE', 11, NOW())),
('user13', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick13', 'BBB', '010-0013-0013', 'user13@example.com', DATEADD('MINUTE', 12, NOW()), DATEADD('MINUTE', 12, NOW())),
('user14', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick14', 'C', '010-0014-0014', 'user14@example.com', DATEADD('MINUTE', 13, NOW()), DATEADD('MINUTE', 13, NOW())),
('user15', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick15', 'CA', '010-0015-0015', 'user15@example.com', DATEADD('MINUTE', 14, NOW()), DATEADD('MINUTE', 14, NOW())),
('user16', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick16', 'CAA', '010-0016-0016', 'user16@example.com', DATEADD('MINUTE', 15, NOW()), DATEADD('MINUTE', 15, NOW())),
('user17', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick17', 'D', '010-0017-0017', 'user17@example.com', DATEADD('MINUTE', 16, NOW()), DATEADD('MINUTE', 16, NOW())),
('user18', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick18', 'DA', '010-0018-0018', 'user18@example.com', DATEADD('MINUTE', 17, NOW()), DATEADD('MINUTE', 17, NOW())),
('user19', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick19', 'DAA', '010-0019-0019', 'user19@example.com', DATEADD('MINUTE', 18, NOW()), DATEADD('MINUTE', 18, NOW())),
('user20', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick20', 'E', '010-0020-0020', 'user20@example.com', DATEADD('MINUTE', 19, NOW()), DATEADD('MINUTE', 19, NOW())),
('user21', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick21', 'EA', '010-0021-0021', 'user21@example.com', DATEADD('MINUTE', 20, NOW()), DATEADD('MINUTE', 20, NOW())),
('user22', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick22', 'EAA', '010-0022-0022', 'user22@example.com', DATEADD('MINUTE', 21, NOW()), DATEADD('MINUTE', 21, NOW())),
('user23', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick23', 'EB', '010-0023-0023', 'user23@example.com', DATEADD('MINUTE', 22, NOW()), DATEADD('MINUTE', 22, NOW())),
('user24', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick24', 'EBA', '010-0024-0024', 'user24@example.com', DATEADD('MINUTE', 23, NOW()), DATEADD('MINUTE', 23, NOW())),
('user25', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick25', 'EBB', '010-0025-0025', 'user25@example.com', DATEADD('MINUTE', 24, NOW()), DATEADD('MINUTE', 24, NOW())),
('user26', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick26', 'F', '010-0026-0026', 'user26@example.com', DATEADD('MINUTE', 25, NOW()), DATEADD('MINUTE', 25, NOW())),
('user27', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick27', 'FA', '010-0027-0027', 'user27@example.com', DATEADD('MINUTE', 26, NOW()), DATEADD('MINUTE', 26, NOW())),
('user28', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick28', 'FAA', '010-0028-0028', 'user28@example.com', DATEADD('MINUTE', 27, NOW()), DATEADD('MINUTE', 27, NOW())),
('user29', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick29', 'FB', '010-0029-0029', 'user29@example.com', DATEADD('MINUTE', 28, NOW()), DATEADD('MINUTE', 28, NOW())),
('user30', '$2a$10$Rk9b31hgpl57zSxGf3IGRuS0FvnZE.J05CgobCXAGR5noaFBvHRMy', 'Nick30', 'FBA', '010-0030-0030', 'user30@example.com', DATEADD('MINUTE', 29, NOW()), DATEADD('MINUTE', 29, NOW()));

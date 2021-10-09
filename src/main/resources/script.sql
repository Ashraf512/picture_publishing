-- INSERT INTO users (id, username, email, password)
-- VALUES (1, 'admin', ''admin', 'admin123') ON CONFLICT DO nothing;

  INSERT INTO users ( name , username, password)
 VALUES ( 'admin', 'admin', 'admin123') ;
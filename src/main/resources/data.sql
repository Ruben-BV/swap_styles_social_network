INSERT INTO users (user_id, user_type, user_name, email_address, profile_image) VALUES (default,'ADMIN','Paula','admin@swapstyles.com','https://github.com/Ruben-BV/images_test/blob/main/Profil_Images/Admin_Paula.jpeg?raw=true');
INSERT INTO users (user_id, user_type, user_name, email_address, profile_image) VALUES (default,'USER','Sam','sam@email.com','https://github.com/Ruben-BV/images_test/blob/main/Profil_Images/Sam.jpeg?raw=true');
INSERT INTO users (user_id, user_type, user_name, email_address, profile_image) VALUES (default,'USER','Maria','maria@email.com','https://github.com/Ruben-BV/images_test/blob/main/Profil_Images/Maria.jpeg?raw=true');
INSERT INTO users (user_id, user_type, user_name, email_address, profile_image) VALUES (default,'USER','Daniel','daniel@email.com','https://github.com/Ruben-BV/images_test/blob/main/Profil_Images/Daniel.jpeg?raw=true');
INSERT INTO users (user_id, user_type, user_name, email_address, profile_image) VALUES (default,'USER','Ana','ana@email.com','https://github.com/Ruben-BV/images_test/blob/main/Profil_Images/Ana.jpeg?raw=true');

INSERT INTO wardrobes (wardrobe_id, user_id, wardrobe_name) VALUES (default, 2, 'My Wardrobe');
INSERT INTO wardrobes (wardrobe_id, user_id, wardrobe_name) VALUES (default, 3, 'Favorites');
INSERT INTO wardrobes (wardrobe_id, user_id, wardrobe_name) VALUES (default, 3, 'Wardrobe to share');
INSERT INTO wardrobes (wardrobe_id, user_id, wardrobe_name) VALUES (default, 4, 'Daniel - Wardrobe to share');

INSERT INTO wearables (wearable_id, wardrobe_id, wearable_type, wearable_name, wearable_description, visibility, photos_list) VALUES (default, 3, 6, 'My skirt', 'Black long skirt', true, '');
INSERT INTO wearables (wearable_id, wardrobe_id, wearable_type, wearable_name, wearable_description, visibility, photos_list) VALUES (default, 4, 9, 'Harry Potter', 'With plastic glasses, cloak and magic wand', false, '');
INSERT INTO wearables (wearable_id, wardrobe_id, wearable_type, wearable_name, wearable_description, visibility, photos_list) VALUES (default, 4, 9, 'Superman', 'Bodysuit and cloak', true, '');

INSERT INTO friendships (friendship_id, user1_id, user2_id, friendship_status) VALUES (default, 3, 4, 1);
INSERT INTO friendships (friendship_id, user1_id, user2_id, friendship_status) VALUES (default, 3, 5, 0);
INSERT INTO friendships (friendship_id, user1_id, user2_id, friendship_status) VALUES (default, 2, 5, 2);
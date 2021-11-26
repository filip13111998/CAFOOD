insert into image(image_content,image_deleted ,image_name) values
		(lo_import('C:\Users\Public\kts_pics\dvica.png') , true ,'dvica.png'),
		(lo_import('C:\Users\Public\kts_pics\sest.png') , true ,'sest.png');
		
insert into my_user(username,password ,first_name,last_name,delete_user,user_role,image_id) values
		('u1', 'p1', 'f1','l1',true ,'ADMIN',1),
		('u2', 'p2', 'f2','l2',true ,'MANAGER',1);
		
		
insert into salary(active,salary_date_of_created ,salary_price) values
		(true, '2021-11-11', 40000),
		(true, '2021-11-09', 65000);
		
insert into my_user_salary(my_user_user_id , salary_salary_id) values
		(1,1),
		(2,2);
--commit;
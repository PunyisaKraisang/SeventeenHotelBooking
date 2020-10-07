drop table menu;

-- create menu related tables ---------------------------------------------------------------------------
create table menu (
    menu_id number(5) primary key,
    name nvarchar2(100) not null,
    price number(7, 2) not null,
    recommended number(1) default 0,
    description nvarchar2(500)
);

create table menu_keyword (
    keyword_id number(5) primary key,
    value nvarchar2(20) not null,
    category nvarchar2(20) not null
);

create table menu_keyword_map (
    menu_id number(5) references menu (menu_id),
    keyword_id number(5) references menu_keyword (keyword_id)
);


-- insert menu ------------------------------------------------------------------------------------------
insert into menu (menu_id, name, price, description) 
values ( 1, 'Chicano Chicken Burrito', 11.5,
    'Grilled chicken thigh in our achiote marinade, black beans, Spanish rice, and pico de gallo. Contains gluten and nightshades. We cannot make substitutions.');
insert into menu (menu_id, name, price, description) 
values ( 2, 'Gambler Roll', 16.5,
    'Spicy white tuna topped with salmon, pineapple with spicy mayo, and house special spicy sauce. One of the pieces is extremely spicy.');
insert into menu (menu_id, name, price, description) 
values ( 3, 'Omakase Sashimi 20 pcs', 99.99,
    'Chef''s choice assorted sashimi');
insert into menu (menu_id, name, price, description) 
values ( 4, 'House Special Fried Rice with Pork Bundle', 14.99,
    'Served with your choice of Coca-Cola product');
insert into menu (menu_id, name, price, description) 
values ( 5, 'Voodoo and Salad Bundle for 2', 45.85,
    'Provolone, blue cheese and bacon, topped with mushrooms sauteed in ovur spicy voodoo sauce.');
insert into menu (menu_id, name, price, description) 
values ( 6, 'Vegan Mac', 12.5,
    'Rich, creamy and dairy-free! Our homemade sauce has tofu, soy sauce and our secret spice blend. Top with Crispy Breadcrumbs. Vegan. Contains gluten, soy, and nightshades. We cannot make substitutions.');
insert into menu (menu_id, name, price, description) 
values ( 7, 'Green Papaya Salad', 11,
    'Mixture of fresh green papaya, garlic, Thai chili, tomatoes, and peanuts in lime dressing. Served with side cabbage.');
insert into menu (menu_id, name, price, description) 
values ( 8, 'Chardonnay', 28,
    'Sycamore Lane, Napa, California 2013, 750ml White Wine (13.5% ABV)');
insert into menu (menu_id, name, price, description) 
values ( 9, 'Pepperoni, Sausage, and Six Cheese', 17.99,
    '');
insert into menu (menu_id, name, price, description) 
values ( 10, 'Chocolate Overload', 19.8,
    'Alternating layers of chocolate cake and chocolate mousse are topped');


-- insert menu keywords ---------------------------------------------------------------------------------
insert into menu_keyword (keyword_id, value, category) values ( 1, 'American', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 2, 'Mexican', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 3, 'Japanese', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 4, 'Asian', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 5, 'Thai', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 6, 'Taiwanese', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 7, 'Chinese', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 8, 'Italian', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 9, 'Caribbean', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 10, 'Vietnamese', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 11, 'Korean', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 12, 'German', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 13, 'Indian', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 14, 'French', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 15, 'Russian', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 16, 'Indian', 'ethnic');
insert into menu_keyword (keyword_id, value, category) values ( 17, 'French', 'ethnic');

insert into menu_keyword (keyword_id, value, category) values ( 18, 'Fusion', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 19, 'Comfort Food', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 20, 'Bar Food', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 21, 'Fast Food', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 22, 'Family Friendly', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 23, 'Kids Friendly', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 24, 'Healthy', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 25, 'Desserts', 'style');
insert into menu_keyword (keyword_id, value, category) values ( 26, 'Bevourage', 'style');

insert into menu_keyword (keyword_id, value, category) values ( 27, 'Vegetarian', 'dietary');
insert into menu_keyword (keyword_id, value, category) values ( 28, 'Vegan', 'dietary');
insert into menu_keyword (keyword_id, value, category) values ( 29, 'Gluten-free', 'dietary');
insert into menu_keyword (keyword_id, value, category) values ( 30, 'Halal', 'dietary');
insert into menu_keyword (keyword_id, value, category) values ( 31, 'Allergy Friendly', 'dietary');

insert into menu_keyword (keyword_id, value, category) values ( 32, 'Seafood', 'meat');
insert into menu_keyword (keyword_id, value, category) values ( 33, 'Chicken', 'meat');
insert into menu_keyword (keyword_id, value, category) values ( 34, 'Pork', 'meat');
insert into menu_keyword (keyword_id, value, category) values ( 35, 'Beef', 'meat');

insert into menu_keyword (keyword_id, value, category) values ( 36, 'Sushi', 'dish');
insert into menu_keyword (keyword_id, value, category) values ( 37, 'Burgers', 'dish');
insert into menu_keyword (keyword_id, value, category) values ( 38, 'Pizza', 'dish');
insert into menu_keyword (keyword_id, value, category) values ( 39, 'Sushi', 'dish');
insert into menu_keyword (keyword_id, value, category) values ( 40, 'Alcohol', 'dish');
insert into menu_keyword (keyword_id, value, category) values ( 41, 'Chocolatier', 'dish');
insert into menu_keyword (keyword_id, value, category) values ( 42, 'Salads', 'dish');


-- map menu keyword -------------------------------------------------------------------------------------
insert into menu_keyword_map (menu_id, keyword_id) values ( 1, 2);
insert into menu_keyword_map (menu_id, keyword_id) values ( 1, 19);
insert into menu_keyword_map (menu_id, keyword_id) values ( 2, 36);
insert into menu_keyword_map (menu_id, keyword_id) values ( 2, 3);
insert into menu_keyword_map (menu_id, keyword_id) values ( 2, 4);
insert into menu_keyword_map (menu_id, keyword_id) values ( 2, 32);
insert into menu_keyword_map (menu_id, keyword_id) values ( 2, 22);
insert into menu_keyword_map (menu_id, keyword_id) values ( 3, 36);
insert into menu_keyword_map (menu_id, keyword_id) values ( 3, 3);
insert into menu_keyword_map (menu_id, keyword_id) values ( 3, 4);
insert into menu_keyword_map (menu_id, keyword_id) values ( 3, 32);
insert into menu_keyword_map (menu_id, keyword_id) values ( 3, 22);
insert into menu_keyword_map (menu_id, keyword_id) values ( 4, 6);
insert into menu_keyword_map (menu_id, keyword_id) values ( 4, 7);
insert into menu_keyword_map (menu_id, keyword_id) values ( 4, 18);
insert into menu_keyword_map (menu_id, keyword_id) values ( 5, 37);
insert into menu_keyword_map (menu_id, keyword_id) values ( 5, 1);
insert into menu_keyword_map (menu_id, keyword_id) values ( 5, 42);
insert into menu_keyword_map (menu_id, keyword_id) values ( 5, 24);
insert into menu_keyword_map (menu_id, keyword_id) values ( 6, 1);
insert into menu_keyword_map (menu_id, keyword_id) values ( 6, 19);
insert into menu_keyword_map (menu_id, keyword_id) values ( 6, 20);
insert into menu_keyword_map (menu_id, keyword_id) values ( 6, 27);
insert into menu_keyword_map (menu_id, keyword_id) values ( 6, 28);
insert into menu_keyword_map (menu_id, keyword_id) values ( 6, 24);
insert into menu_keyword_map (menu_id, keyword_id) values ( 7, 4);
insert into menu_keyword_map (menu_id, keyword_id) values ( 7, 5);
insert into menu_keyword_map (menu_id, keyword_id) values ( 7, 22);
insert into menu_keyword_map (menu_id, keyword_id) values ( 8, 40);
insert into menu_keyword_map (menu_id, keyword_id) values ( 8, 26);
insert into menu_keyword_map (menu_id, keyword_id) values ( 9, 38);
insert into menu_keyword_map (menu_id, keyword_id) values ( 9, 22);
insert into menu_keyword_map (menu_id, keyword_id) values ( 10, 25);
insert into menu_keyword_map (menu_id, keyword_id) values ( 10, 41);
insert into menu_keyword_map (menu_id, keyword_id) values ( 10, 23);



-- commit -----------------------------------------------------------------------------------------------
commit;


-- select -----------------------------------------------------------------------------------------------
select * from menu;
select * from menu_keyword;
select      mn.name, mk.value
from        menu_keyword_map mp
inner join  menu mn on mn.menu_id = mp.menu_id
inner join  menu_keyword mk on mk.keyword_id = mp.keyword_id
order by    mn.menu_id;


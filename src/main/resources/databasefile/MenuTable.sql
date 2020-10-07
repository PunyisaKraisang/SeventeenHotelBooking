drop table menu;

create table menu (
    menu_id number(5) primary key,
    name nvarchar2(100) not null,
    price number(7, 2) not null,
    recommended number(1) default 0,
    description nvarchar2(500)
);

insert into menu (menu_id, name, price, description) 
values ( 1, 'Chicano Chicken Burrito', 11.5,
    'Grilled chicken thigh in our achiote marinade, black beans, Spanish rice, and pico de gallo. Contains gluten and nightshades. We cannot make substitutions.');
--Mexican • Comfort • Food 
insert into menu (menu_id, name, price, description) 
values ( 2, 'Gambler Roll', 16.5,
    'Spicy white tuna topped with salmon, pineapple with spicy mayo, and house special spicy sauce. One of the pieces is extremely spicy.');
-- Sushi • Japanese • Asian• Seafood • Family Friendly
insert into menu (menu_id, name, price, description) 
values ( 3, 'Omakase Sashimi 20 pcs', 99.99,
    'Chef''s choice assorted sashimi');
-- Sushi • Japanese • Asian • Seafood • Family Friendly
insert into menu (menu_id, name, price, description) 
values ( 4, 'House Special Fried Rice with Pork Bundle', 14.99,
    'Served with your choice of Coca-Cola product');
-- Taiwanese • Chinese • Asian Fusion
insert into menu (menu_id, name, price, description) 
values ( 5, 'Voodoo and Salad Bundle for 2', 45.85,
    'Provolone, blue cheese and bacon, topped with mushrooms sauteed in ovur spicy voodoo sauce.');
-- Burgers • American • Salads • Family Meals • Healthy
insert into menu (menu_id, name, price, description) 
values ( 6, 'Vegan Mac', 12.5,
    'Rich, creamy and dairy-free! Our homemade sauce has tofu, soy sauce and our secret spice blend. Top with Crispy Breadcrumbs. Vegan. Contains gluten, soy, and nightshades. We cannot make substitutions.');
-- American • Comfort Food • Bar Food • Vegetarian • Vegan • Healthy
insert into menu (menu_id, name, price, description) 
values ( 7, 'Green Papaya Salad', 11,
    'Mixture of fresh green papaya, garlic, Thai chili, tomatoes, and peanuts in lime dressing. Served with side cabbage.');
-- Thai • Asian • Family Friendly  
insert into menu (menu_id, name, price, description) 
values ( 8, 'Chardonnay', 28,
    'Sycamore Lane, Napa, California 2013, 750ml White Wine (13.5% ABV)');
-- Alcohol • Bevourage
insert into menu (menu_id, name, price, description) 
values ( 9, 'Pepperoni, Sausage, and Six Cheese', 17.99,
    '');
--  Pizza • Family Friendly
insert into menu (menu_id, name, price, description) 
values ( 10, 'Chocolate Overload', 19.8,
    'Alternating layers of chocolate cake and chocolate mousse are topped');
--  Desserts • chocolatier • Kids Friendly

commit;


select * from menu;
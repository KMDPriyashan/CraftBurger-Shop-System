CREATE DATABASE IF NOT EXISTS craft_burger_db;
USE craft_burger_db;

-- 1. USER & STAFF MANAGEMENT TABLE

DROP TABLE IF EXISTS users;
CREATE TABLE users (
user_id INT AUTO_INCREMENT PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
role ENUM('Admin', 'Store Manager', 'Cashier', 'Kitchen Staff') NOT NULL DEFAULT 'Cashier',
status ENUM('Active', 'Inactive') DEFAULT 'Active',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample Users Data
INSERT INTO users (full_name, username, password, role) VALUES
('Kamal Perera', 'admin', 'admin123', 'Admin'),
('John Doe', 'john', 'manager123', 'Store Manager'),
('Nimal Silva', 'nimal', 'cashier123', 'Cashier'),
('Sunil Fernando', 'sunil', 'kitchen123', 'Kitchen Staff');

-- 2. CUSTOMERS / MEMBERS TABLE

DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
cust_code VARCHAR(20) NOT NULL UNIQUE,
name VARCHAR(100) NOT NULL,
phone VARCHAR(15) NOT NULL UNIQUE,
email VARCHAR(100),
loyalty_points INT DEFAULT 0,
registered_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample Customer Data
INSERT INTO customers (cust_code, name, phone, email, loyalty_points) VALUES
('CUST-001', 'Kasun Perera', '0779876543', 'kasun@gmail.com', 120),
('CUST-002', 'Nimali Fernando', '0712345678', 'nimali@yahoo.com', 45),
('CUST-003', 'Dilshan Silva', '0751122334', 'dilshan@hotmail.com', 80),
('CUST-004', 'Sahan Jayasinghe', '0789988776', 'sahan@gmail.com', 10);

-- 3. MENU CATEGORIES TABLE

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
category_id INT AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR(50) NOT NULL UNIQUE,
description VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample Category Data
INSERT INTO categories (category_name, description) VALUES
('Beef', '100% Prime Angus Beef Burgers'),
('Chicken', 'Crispy Fried & Flame Grilled Chicken Burgers'),
('Veggie', 'Plant-based & Vegetarian Burgers'),
('Seafood', 'Fresh Fish & Seafood Specials'),
('Combos', 'Burger + Fries + Beverage Value Deals'),
('Beverages', 'Refreshing Soft Drinks & Shakes');

-- 4. BURGER & MENU ITEMS TABLE

DROP TABLE IF EXISTS items;
CREATE TABLE items (
item_id INT AUTO_INCREMENT PRIMARY KEY,
item_code VARCHAR(20) NOT NULL UNIQUE,
item_name VARCHAR(100) NOT NULL,
category_id INT NOT NULL,
unit_price DECIMAL(10, 2) NOT NULL,
qty_on_hand INT DEFAULT 0,
description TEXT,
image_path VARCHAR(255) DEFAULT '/images/default.png',
status ENUM('Available', 'Out of Stock') DEFAULT 'Available',
FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample Items Data (20 Burgers & Specials matching your catalog UI)
INSERT INTO items (item_code, item_name, category_id, unit_price, qty_on_hand, description) VALUES
('BG-001', 'Classic Beef Burger', 1, 850.00, 45, '100% Angus beef patty with fresh lettuce & signature sauce.'),
('BG-002', 'Double Cheese Supreme', 1, 1120.00, 30, 'Double beef patty layered with aged cheddar cheese and pickles.'),
('BG-003', 'Spicy Zinger Chicken', 2, 950.00, 38, 'Crispy fried spicy chicken breast with chili mayo spread.'),
('BG-004', 'Bacon Avocado Smash', 1, 1280.00, 20, 'Smoky crispy bacon, smashed beef patty, and guacamole.'),
('BG-005', 'BBQ Smokehouse King', 1, 1350.00, 18, 'Charbroiled beef patty soaked in hickory BBQ sauce with onion rings.'),
('BG-006', 'Crispy Fish Filet', 4, 890.00, 25, 'Golden fried fish patty topped with tartar sauce & crisp lettuce.'),
('BG-007', 'Mushroom Swiss Delight', 1, 1090.00, 22, 'Sautéed mushrooms, Swiss cheese, and truffle garlic mayo.'),
('BG-008', 'Garden Veggie Patty', 3, 790.00, 50, 'Plant-based patty served with avocado spread & whole wheat bun.'),
('BG-009', 'Triple Stack Monster', 1, 1590.00, 12, 'Three beef patties, triple cheese, bacon & signature burger sauce.'),
('BG-010', 'Buffalo Chicken Crunch', 2, 990.00, 32, 'Spicy buffalo sauce dipped chicken with blue cheese dressing.'),
('BG-011', 'Teriyaki Glazed Burger', 1, 1050.00, 28, 'Beef patty glazed with Japanese teriyaki sauce and grilled pineapple.'),
('BG-012', 'Jalapeño Inferno', 1, 1100.00, 19, 'Pickled jalapeños, pepper jack cheese, and spicy habanero sauce.'),
('BG-013', 'Grilled Chicken Pesto', 2, 980.00, 27, 'Flame-grilled chicken breast with basil pesto and fresh mozzarella.'),
('BG-014', 'Beyond Meat Vegan', 3, 1150.00, 40, '100% plant-based Beyond burger patty with vegan mayo.'),
('BG-015', 'Pulled Pork BBQ Burger', 1, 1200.00, 15, 'Slow-cooked pulled pork topped with tangy coleslaw.'),
('BG-016', 'Egg & Cheeseburger', 1, 920.00, 35, 'Sunny-side up fried egg over juicy beef patty and cheddar cheese.'),
('BG-017', 'Honey Mustard Chicken', 2, 940.00, 30, 'Tender chicken breast with sweet honey mustard glaze.'),
('BG-018', 'Black Bean Spicy Burger', 3, 820.00, 25, 'Spicy black bean and corn patty with chipotle mayo.'),
('BG-019', 'Truffle Beef Master', 1, 1650.00, 10, 'Premium Wagyu beef patty with real black truffle butter sauce.'),
('BG-020', 'Mini Slider Trio', 5, 1390.00, 16, 'Set of 3 mini sliders: Beef Cheese, Spicy Chicken, & BBQ Pork.');

-- 5. ORDERS TABLE

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
order_id INT AUTO_INCREMENT PRIMARY KEY,
order_code VARCHAR(20) NOT NULL UNIQUE,
customer_id INT NULL,
user_id INT NOT NULL,
subtotal DECIMAL(10, 2) NOT NULL,
tax_amount DECIMAL(10, 2) DEFAULT 0.00,
discount_amount DECIMAL(10, 2) DEFAULT 0.00,
net_total DECIMAL(10, 2) NOT NULL,
payment_type ENUM('Cash', 'Card', 'QR') NOT NULL DEFAULT 'Cash',
order_status ENUM('Preparing', 'Ready', 'Completed', 'Cancelled') NOT NULL DEFAULT 'Preparing',
order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE SET NULL,
FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample Orders Data
INSERT INTO orders (order_code, customer_id, user_id, subtotal, tax_amount, discount_amount, net_total, payment_type, order_status) VALUES
('ORD-1001', 1, 3, 2550.00, 127.50, 255.00, 2422.50, 'Cash', 'Preparing'),
('ORD-1002', 2, 3, 1200.00, 60.00, 0.00, 1260.00, 'Card', 'Ready'),
('ORD-1003', NULL, 3, 2370.00, 118.50, 0.00, 2488.50, 'Cash', 'Completed'),
('ORD-1004', 3, 3, 1850.00, 92.50, 185.00, 1757.50, 'QR', 'Preparing'),
('ORD-1005', 4, 3, 3400.00, 170.00, 340.00, 3230.00, 'Cash', 'Completed');

-- 6. ORDER DETAILS / LINE ITEMS TABLE

DROP TABLE IF EXISTS order_details;
CREATE TABLE order_details (
detail_id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT NOT NULL,
item_id INT NOT NULL,
unit_price DECIMAL(10, 2) NOT NULL,
qty INT NOT NULL,
total_price DECIMAL(10, 2) NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Sample Order Details Data
INSERT INTO order_details (order_id, item_id, unit_price, qty, total_price) VALUES
(1, 2, 1120.00, 2, 2240.00), -- Order 1001: 2x Double Cheese Supreme
(1, 1, 850.00, 1, 850.00),   -- Order 1001: 1x Classic Beef
(2, 3, 950.00, 1, 950.00),   -- Order 1002: 1x Spicy Zinger
(3, 8, 790.00, 3, 2370.00),  -- Order 1003: 3x Garden Veggie
(4, 4, 1280.00, 1, 1280.00), -- Order 1004: 1x Bacon Avocado
(5, 1, 850.00, 4, 3400.00);  -- Order 1005: 4x Classic Beef

-- HELPER VIEWS FOR EASY JAVAFX TABLE BINDING

-- View to get complete Order Summaries
CREATE OR REPLACE VIEW vw_order_summary AS
SELECT
o.order_id,
o.order_code,
COALESCE(c.name, 'Walk-in Customer') AS customer_name,
u.full_name AS cashier_name,
o.net_total,
o.payment_type,
o.order_status,
o.order_date
FROM orders o
LEFT JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN users u ON o.user_id = u.user_id;
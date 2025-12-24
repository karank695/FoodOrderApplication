# 🍔 Online Food Ordering System

## 📌 Overview
An in-memory **Online Food Ordering System** that integrates with restaurants and auto-assigns customer orders based on configurable selection strategies such as **Lowest Bill Cost** or **Highest Rating**.

This application is designed with **clean architecture, modularity, and extensibility** in mind and does **not use any database**.

---

## ✨ Features

### 🏪 Restaurant Management
- Onboard new restaurants
- Update restaurant menu (item addition only)
- Each restaurant has:
  - Rating (1–5)
  - Menu with item prices
  - Maximum concurrent order limit

---

### 🛒 Order Management
- Customers can place orders with:
  - Items and quantities
  - Selection strategy
- Orders are:
  - Auto-assigned to one restaurant
  - Accepted only if all items are available
  - Rejected if restaurant capacity is full
- Order lifecycle:
  - `ACCEPTED → COMPLETED`
  - Accepted orders cannot be cancelled
  - Completed orders free up restaurant capacity

---

### 🧠 Selection Strategy (Pluggable)
- Strategy Pattern used
- Implemented strategies:
  - Lowest Bill Cost
  - Highest Rating
- Easily extendable with new strategies

---

## 🏗️ API request/response on swagger
<img width="701" height="399" alt="image" src="https://github.com/user-attachments/assets/6f2bca08-89e7-4d49-a82b-6dd67da06670" />


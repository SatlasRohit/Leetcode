/* Write your PL/SQL query statement below */
Select name AS Customers from Customers where id NOT IN(
    Select customerId from Orders
);
/* Write your PL/SQL query statement below */
Select email from Person 
Group by email 
Having COUNT(*)>1;
# Write your MySQL query statement below
select name as Employee from employee join (select id,salary from employee where id in (select managerId from employee)) as temp on employee.managerId = temp.id where employee.salary > temp.salary;
# select managerId,salary from employee where id in (select managerId from employee);
# select managerId,salary from employee where id in (select managerId from employee);
# select managerId from employee;
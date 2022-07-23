# Write your MySQL query statement below
select firstName, LastName, city, state from person left join Address on person.personId = address.personId;

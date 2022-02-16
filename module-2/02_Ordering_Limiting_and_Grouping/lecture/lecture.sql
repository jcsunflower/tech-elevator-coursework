-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
Select *
From state
ORDER BY population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
Select state.state_name, state.census_region
From state
ORDER BY state.census_region DESC, state_name ASC;


-- The biggest park by area
SELECT park_name, area
FROM park
ORDER BY area DESC;



-- LIMITING RESULTS

-- The 10 largest cities by populations

SELECT city_name
FROM city
ORDER BY area DESC
LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

SELECT park_name, date_established
FROM park
ORDER BY park_name ASC, date_established ASC
LIMIT 20;


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.

SELECT city_name || '(' || state_abbreviation || ')'
FROM city;

-- The all parks by name and date established.


-- The census region and state name of all states in the West & Midwest sorted in ascending order.



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.

SELECT AVG(population)
FROM state;


-- Total population in the West and South census regions

SELECT SUM(population)
FROM state
WHERE census_region IN ('West', 'South');


-- The number of cities with populations greater than 1 million
SELECT COUNT(population)
FROM city
WHERE population > 1000000;


-- The number of state nicknames.



-- The area of the smallest and largest parks.
SELECT MIN(area), MAX(area)
FROM park;



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) as total_cities
FROM city
GROUP BY state_abbreviation
ORDER BY total_cities DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_area
FROM park
GROUP BY has_camping;



-- Sum of the population of cities in each state ordered by state abbreviation.

SELECT state_abbreviation, SUM(population) AS total_population
FROM city
GROUP BY state_abbreviation
HAVING SUM(population) > 4000000
ORDER BY total_population DESC;




-- The smallest city population in each state ordered by city population.



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

SELECT *
FROM city
WHERE city.state_abbreviation IN (
	SELECT state_abbreviation
	FROM state
	WHERE census_region = 'West'
	);

-- Include state name rather than the state abbreviation while counting the number of cities in each state,

-- outer query
SELECT city.city_name, city.state_abbreviation,
(
	-- inner query/subquery/correlated subquery
	-- returning one column, one row
	SELECT state.state_name
	FROM state
	WHERE state.state_abbreviation = city.state_abbreviation
) AS state_name
FROM city;


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.


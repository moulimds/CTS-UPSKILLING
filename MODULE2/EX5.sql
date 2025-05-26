SELECT 
    u.city,
    COUNT(DISTINCT r.user_id) as distinct_registrations
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY distinct_registrations DESC
LIMIT 5;

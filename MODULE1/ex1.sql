SELECT 
    u.full_name,
    u.city,
    e.title,
    e.start_date,
    e.end_date
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e ON r.event_id = e.event_id
WHERE e.status = 'upcoming' 
    AND e.city = u.city
ORDER BY e.start_date;

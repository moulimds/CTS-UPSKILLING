SELECT 
    e.title,
    e.city,
    e.status,
    COUNT(r.registration_id) as registration_count
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title, e.city, e.status
ORDER BY registration_count DESC
LIMIT 3;

SELECT 
    e.event_id,
    e.title,
    e.city,
    e.status
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.event_id IS NULL
ORDER BY e.start_date;

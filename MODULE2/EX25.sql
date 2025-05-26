SELECT 
    e.event_id,
    e.title,
    e.city,
    e.status,
    e.start_date,
    e.end_date
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.event_id IS NULL
ORDER BY e.start_date;

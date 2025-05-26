SELECT 
    e.title,
    e.city,
    COUNT(s.session_id) as sessions_10am_to_12pm
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
    AND TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.event_id, e.title, e.city
ORDER BY sessions_10am_to_12pm DESC;

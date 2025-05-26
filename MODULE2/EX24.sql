SELECT 
    e.title,
    e.city,
    COUNT(s.session_id) as total_sessions,
    ROUND(AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) as avg_duration_minutes
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title, e.city
HAVING COUNT(s.session_id) > 0
ORDER BY avg_duration_minutes DESC;

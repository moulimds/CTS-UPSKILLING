SELECT 
    e.title,
    e.city,
    e.status,
    COUNT(s.session_id) as session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title, e.city, e.status
HAVING COUNT(s.session_id) = (
    SELECT MAX(session_count)
    FROM (
        SELECT COUNT(s2.session_id) as session_count
        FROM Events e2
        LEFT JOIN Sessions s2 ON e2.event_id = s2.event_id
        GROUP BY e2.event_id
    ) max_sessions
);

SELECT 
    speaker_name,
    COUNT(session_id) as session_count,
    COUNT(DISTINCT event_id) as events_count
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1
ORDER BY session_count DESC;

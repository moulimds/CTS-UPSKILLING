SELECT 
    u.full_name as organizer_name,
    u.email,
    COUNT(CASE WHEN e.status = 'upcoming' THEN 1 END) as upcoming_events,
    COUNT(CASE WHEN e.status = 'completed' THEN 1 END) as completed_events,
    COUNT(CASE WHEN e.status = 'cancelled' THEN 1 END) as cancelled_events,
    COUNT(e.event_id) as total_events
FROM Users u
LEFT JOIN Events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name, u.email
HAVING COUNT(e.event_id) > 0
ORDER BY total_events DESC;

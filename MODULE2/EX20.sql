SELECT 
    u.full_name,
    u.email,
    u.city,
    COUNT(DISTINCT r.event_id) as events_registered,
    COUNT(f.feedback_id) as feedback_submitted,
    ROUND(
        CASE 
            WHEN COUNT(DISTINCT r.event_id) = 0 THEN 0
            ELSE COUNT(f.feedback_id) / COUNT(DISTINCT r.event_id) * 100
        END, 2
    ) as engagement_percentage
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name, u.email, u.city
ORDER BY engagement_percentage DESC;

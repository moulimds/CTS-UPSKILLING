SELECT 
    u.full_name,
    u.email,
    e.title as event_name,
    f.rating,
    f.comments,
    f.feedback_date
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3
ORDER BY f.feedback_date DESC;

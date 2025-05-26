SELECT 
    u.full_name,
    u.email,
    u.city,
    COUNT(f.feedback_id) as feedback_count,
    ROUND(AVG(f.rating), 2) as avg_rating_given
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name, u.email, u.city
ORDER BY feedback_count DESC
LIMIT 5;

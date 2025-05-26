SELECT 
    e.city,
    COUNT(f.feedback_id) as total_feedback,
    ROUND(AVG(f.rating), 2) as avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;

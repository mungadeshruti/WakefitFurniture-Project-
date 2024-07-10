package com.wakefit.ecommerce.service;

import com.wakefit.ecommerce.entity.Feedback;

public interface FeedbackService {
    Feedback addFeedback(Feedback feedback);
    Feedback getFeedbackById(Long feedbackId);
    Feedback updateFeedback(Long feedbackId, Feedback feedback);
    void deleteFeedback(Long feedbackId);
    
}

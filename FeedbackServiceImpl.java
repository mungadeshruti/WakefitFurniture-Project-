package com.wakefit.ecommerce.serviceimplement;

import com.wakefit.ecommerce.entity.Feedback;
import com.wakefit.ecommerce.exception.ResourceNotFoundException;
import com.wakefit.ecommerce.repository.FeedbackRepository;
import com.wakefit.ecommerce.service.FeedbackService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + feedbackId));
    }

    @Override
    @Transactional
    public Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback) {
        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + feedbackId));

        existingFeedback.setRating(updatedFeedback.getRating());
        existingFeedback.setComment(updatedFeedback.getComment());
        existingFeedback.setFeedbackDate(updatedFeedback.getFeedbackDate());

        return feedbackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        if (feedbackRepository.existsById(feedbackId)) {
            feedbackRepository.deleteById(feedbackId);
        } else {
            throw new ResourceNotFoundException("Feedback not found with id " + feedbackId);
        }
    }
}

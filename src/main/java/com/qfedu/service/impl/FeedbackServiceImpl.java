package com.qfedu.service.impl;

import com.qfedu.domain.Feedback;
import com.qfedu.mapper.FeedbackMapper;
import com.qfedu.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public int addFeedback(Feedback feedbacks) {
        return feedbackMapper.insert(feedbacks);
    }
}

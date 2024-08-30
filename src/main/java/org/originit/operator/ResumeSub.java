package org.originit.operator;

import org.springframework.stereotype.Component;

@Component
public interface ResumeSub {
    void login();
    ResumeSub city(String[]cities);
    ResumeSub salary(int min,int max);
    ResumeSub experience(String[]experiences);
    ResumeSub jobType(String[]types);
    ResumeSub page(int pageNum);
    void startResumeSubmission();
}
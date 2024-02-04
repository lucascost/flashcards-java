package com.lucascost.flashcards.dto;

import java.util.List;

public class TagListRequest {
    List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

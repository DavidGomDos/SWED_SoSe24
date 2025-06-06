package Exercise_6;

class ContentSizeComparisonStrategy implements CompareWebsite {
    @Override
    public boolean compare(Website website1, Website website2) {
        return website1.getContentSize() == website2.getContentSize();
    }
}

class HtmlContentComparisonStrategy implements CompareWebsite {
    @Override
    public boolean compare(Website website1, Website website2) {
        return website1.getHtmlContent().equals(website2.getHtmlContent());
    }
}

class TextContentComparisonStrategy implements CompareWebsite {
    @Override
    public boolean compare(Website website1, Website website2) {
        return website1.getTextContent().equals(website2.getTextContent());
    }
}


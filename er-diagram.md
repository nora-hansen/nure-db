````mermaid
---
ER diagram test
---
erDiagram
    IMAGE ||--o{ CHARACTER : contains
    IMAGE ||--o{ TAG : tagged_with
    IMAGE ||--o{ SOURCE : available_at
    IMAGE {
        string title
        string description
        string date
        string software
    }
    CHARACTER ||--o{ GROUP : is_in
    CHARACTER }o--|| CHARACTER : based_on
    CHARACTER {
        string name
        int age
        string bio
        string group
    }
    GROUP {
        string name
        string description
        Character[] members
    }
    MUSIC ||--o{ IMAGE : has
    MUSIC |o--o{ TAG : tagged_with
    MUSIC ||--o{ SOURCE : available_at
    MUSIC }o--o{ VOCALIST : sung_by
    MUSIC ||--o{ MUSIC : alternate_version_of
    MUSIC {
        string title
        int seconds
        string firstDate
        string latestDate
        string DAW
        string description
        string lyrics
    }
    MUSIC }o--o{ RELEASE : is_in
    RELEASE ||--o{ SOURCE : available_at
    RELEASE {
        string title
        string date
    }
    VOCALIST {
        string name
        string engine
        string URL
    }
    TAG {
        string value
    }
    SOURCE {
        string URL
        string host
        bool isPublic
    }

````
````mermaid
---
ER diagram test
---
erDiagram
    SOURCE {
        string name
        string URL
        string host
        bool isPublic
        date createdAt
        date updatedAt
    }
    PROFILE {
        string name
        date createdAt
        date updatedAt
    }
    TAG {
        string value
        date createdAt
        date updatedAt
    }
    MUSIC ||--o{ ARTWORK : has
    MUSIC |o--o{ TAG : tagged_with
    MUSIC ||--o{ SOURCE : available_at
    MUSIC }o--o{ VOCALIST : sung_by
    MUSIC ||--o{ MUSIC : alternate_version_of
    MUSIC {
        string title
        int seconds
        Date firstDate
        Date latestDate
        string DAW
        string description
        string lyrics
        string isrc
        bool isRemake
        date createdAt
        date updatedAt
    }
    MUSIC }o--o{ RELEASE : is_in
    RELEASE ||--o{ SOURCE : available_at
    RELEASE {
        string title
        string date
        date createdAt
        date updatedAt
    }
    VOCALIST {
        string name
        string engine
        string URL
        date createdAt
        date updatedAt
    }
    VOICE_BANK ||--o{ SOURCE : available_at
    VOICE_BANK ||--|| PROFILE : voiced_by
    VOICE_BANK {
        string name
        string engine
        date createdAt
        date updatedAt
    }
    CHARACTER ||--o{ GROUP : is_in
    CHARACTER }o--|| CHARACTER : based_on
    CHARACTER {
        string name
        int age
        string bio
        string group
        bool isOC
        date createdAt
        date updatedAt
    }
    GROUP {
        string name
        string description
        date createdAt
        date updatedAt
    }
    ARTWORK ||--o{ CHARACTER : contains
    ARTWORK ||--o{ TAG : tagged_with
    ARTWORK ||--o{ SOURCE : available_at
    ARTWORK {
        string title
        string description
        date date
        string software
        date createdAt
        date updatedAt
    }
    VIDEO ||--o{ SOURCE : available_at
    VIDEO ||--o{ CHARACTER : contains
    VIDEO {
        string title
        string description 
        int seconds
        date createdAt
        date updatedAt
    }
    FILE ||--o{ SOURCE : available_at
    FILE {
        string title
        string type
        date createdAt
        date updatedAt
    }




````
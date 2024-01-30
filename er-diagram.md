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
    }
    CHARACTER ||--|| GROUP : is_in
    CHARACTER {
        string name
        string bio
        string group
    }
    TAG {
        string value
    }
    GROUP {
        string name
        string description
    }
    MUSIC ||--o{ IMAGE : has
    MUSIC ||--o{ SOURCE : available_at
    MUSIC }o--o{ VOCALIST : sung_by
    MUSIC {
        string title
        int seconds
        string firstDate
        string latestDate
        string DAW
        string lyrcs
    }
    SOURCE {
        string URL
        string host
    }
    VOCALIST {
        string name
        string engine
        string URL
    }
````
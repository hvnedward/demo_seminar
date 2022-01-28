package com.example.demo_di.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
class Note(
    @PrimaryKey
    var id: Int?,
    var title: String?,
    var desc: String?,
    var priority: Int?,
    var createdDate: Long?,
    var updatedDate: Long?,
    var notifiedDate: Long?
) {
    class Builder {
        var id: Int? = null
        var title: String? = null
        var desc: String? = null
        var priority: Int? = null
        var createdDate: Long? = null
        var updatedDate: Long? = null
        var notifiedDate: Long? = null
        fun id(id: Int) {
            this.id = id
        }

        fun title(title: String?) {
            this.title = title
        }

        fun desc(desc: String?) {
            this.desc = desc
        }

        fun priority(priority: Int?) {
            this.priority = priority
        }

        fun createdDate(createdDate: Long?) {
            this.createdDate = createdDate
        }

        fun updatedDate(updatedDate: Long?) {
            this.updatedDate = updatedDate
        }

        fun notifiedDate(notifiedDate: Long?) {
            this.notifiedDate = notifiedDate
        }

        fun build() = Note(id, title, desc, priority, createdDate, updatedDate, notifiedDate)
    }

}
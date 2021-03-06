package io.github.edgeatzero.booksource

import io.github.edgeatzero.booksource.models.Book
import io.github.edgeatzero.booksource.models.Chapter
import io.github.edgeatzero.booksource.models.Contents
import io.github.edgeatzero.booksource.resource.ResourceContainer
import java.io.Closeable
import java.io.IOException
import java.util.*

/**
 *  书源抽象类
 *
 *  继承此接口以实现书源功能
 * */
public abstract class BookSource : Closeable {

    /**
     *  唯一id
     * */
    public abstract val id: String

    /**
     *  语言
     * */
    public abstract val lang: Locale

    /**
     *  初始化
     * */
    @Throws(RuntimeException::class)
    public abstract fun install()

    /**
     *  通过书籍id获取书籍的信息
     * */
    @Throws(IllegalArgumentException::class, IOException::class)
    public abstract suspend fun fetch(id: String): Book

    /**
     * 获取书籍的章节
     * */
    @Throws(IllegalArgumentException::class, IOException::class)
    public abstract suspend fun chapters(book: Book): List<Chapter>

    /**
     * 章节的文本内容
     * */
    @Throws(IllegalArgumentException::class, IOException::class)
    public abstract suspend fun contents(chapter: Chapter): Contents

    /**
     *  关闭占用资源
     * */
    @Throws(IOException::class)
    public abstract override fun close()

    public override fun toString(): String {
        return "BookSource(id='$id', lang=$lang)"
    }

}
<?php

namespace Adri\NewsBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Table(name="`article`")
 * @ORM\Entity
 */
class Article
{
    /**
     * @ORM\Column(type="integer", name="id")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @ORM\Column(type="string", name="title", length=255)
     */
    private $title;

    /**
     * @ORM\Column(type="text", name="content")
     */
    private $content;

    /**
     * @ORM\Column(type="string", name="postedBy", length=255)
     */
    private $postedBy;

    /**
     * @ORM\Column(type="datetime", name="dateAdded")
     */
    private $dateAdded;

    public function __construct()
    {
        $this->dateAdded = new \DateTime();
    }

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set title
     *
     * @param string $title
     * @return Article
     */
    public function setTitle($title)
    {
        $this->title = $title;
    
        return $this;
    }

    /**
     * Get title
     *
     * @return string 
     */
    public function getTitle()
    {
        return $this->title;
    }

    /**
     * Set content
     *
     * @param string $content
     * @return Article
     */
    public function setContent($content)
    {
        $this->content = $content;
    
        return $this;
    }

    /**
     * Get content
     *
     * @return string 
     */
    public function getContent()
    {
        return $this->content;
    }

    /**
     * Set postedBy
     *
     * @param string $postedBy
     * @return Article
     */
    public function setPostedBy($postedBy)
    {
        $this->postedBy = $postedBy;
    
        return $this;
    }

    /**
     * Get postedBy
     *
     * @return string 
     */
    public function getPostedBy()
    {
        return $this->postedBy;
    }

    /**
     * Set dateAdded
     *
     * @param \DateTime $dateAdded
     * @return Article
     */
    public function setDateAdded($dateAdded)
    {
        $this->dateAdded = $dateAdded;
    
        return $this;
    }

    /**
     * Get dateAdded
     *
     * @return \DateTime 
     */
    public function getDateAdded()
    {
        return $this->dateAdded;
    }
}
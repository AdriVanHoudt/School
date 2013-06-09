<?php

namespace Adri\NewsBundle\DataFixtures;

use Adri\NewsBundle\Entity\Article;
use Doctrine\Common\Persistence\ObjectManager;
use Doctrine\Common\DataFixtures\AbstractFixture;
use Doctrine\Common\DataFixtures\OrderedFixtureInterface;

class LoadArticleData extends AbstractFixture implements OrderedFixtureInterface
{
    public function load(ObjectManager $manager)
    {
        $article = new Article();
        $article->setTitle("Test1");
        $article->setContent("ou think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man.");
        $article->setPostedBy("The master");

        $article2 = new Article();
        $article2->setTitle("Test2");
        $article2->setContent("Normally, both your asses would be dead as fucking fried chicken, but you happen to pull this shit while I'm in a transitional period so I don't wanna kill you, I wanna help you. But I can't give you this case, it don't belong to me. Besides, I've already been through too much shit this morning over this case to hand it over to your dumb ass.");
        $article2->setPostedBy("The master");

        $article3 = new Article();
        $article3->setTitle("Test3");
        $article3->setContent("ou think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man.");
        $article3->setPostedBy("The master");

        $manager->persist($article);
        $manager->persist($article2);
        $manager->persist($article3);

        $manager->flush();
    }

    //load order
    public function getOrder()
    {
        return 1;
    }
}
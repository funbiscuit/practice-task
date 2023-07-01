#!/bin/bash
#git clone https://github.com/vmikolyuk/task1.git

git checkout main

git cherry-pick bb7fbdbde65f411588a5bf9c38fc8bfea5305805

git branch feature3

git checkout feature1
git rebase main
git checkout main
git merge feature1

git reset --soft HEAD~2
git commit -m "file1, file2"

git checkout feature3

touch file6

git add --all
git commit -m "file6"

git branch -D feature1
git branch -D feature2

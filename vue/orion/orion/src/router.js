import { createRouter, createWebHistory } from "vue-router";
import MainLayout from "@/layouts/MainLayout";
import HomePage from "@/pages/HomePage";
import NewsPage from "@/pages/NewsPage";
import AboutPage from "@/pages/AboutPage";
import VideoPage from "@/pages/VideoPage";
import NewsDetailPage from "@/pages/NewsDetailPage";
import FaqPage from "@/pages/FaqPage";

const routes = [
    {
        path: '/',
        component: MainLayout,
        children: [
            { path: '', name: 'Home', component: HomePage }
        ]
    },
    {
        path: '/news',
        component: MainLayout,
        children: [
            { path: '', name: 'News', component: NewsPage }
        ]
    },
    {
        path: '/news/:slug',
        component: MainLayout,
        children: [
            { path: '', name: 'NewsDetailPage', component: NewsDetailPage, props: true }
        ]
    },
    {
        path: '/about',
        component: MainLayout,
        children: [
            { path: '', name: 'About', component: AboutPage }
        ]
    },
    {
        path: '/video',
        component: MainLayout,
        children: [
            { path: '', name: 'Video', component: VideoPage }
        ]
    },
    {
        path: '/faq',
        component: MainLayout,
        children: [
            { path: '', name: 'FAQ', component: FaqPage }
        ]
    }
]

export default createRouter({
    history: createWebHistory(),
    routes: routes
})
import KnowledgeBulletListView from "@/views/admin/knowledgeBullet/KnowledgeBulletListView.vue";
import KnowledgeBulletAddView from "@/views/admin/knowledgeBullet/KnowledgeBulletAddView.vue";
import KnowledgeBulletUpdateView from "@/views/admin/knowledgeBullet/KnowledgeBulletUpdateView.vue";
import index from "@/views/admin/index.vue";


const routes=
    {
        path: '/admin/knowledgeBullet',
        name:'index',
        component:index,
        children:[
            {
                path: 'list',
                name: 'knowledgeBulletList',
                component:KnowledgeBulletListView
            },
            {
                path: 'add',
                name: 'knowledgeBulletAdd',
                component:KnowledgeBulletAddView
            },
            {
                path: 'update',
                name: 'knowledgeBulletUpdate',
                component:KnowledgeBulletUpdateView
            },

        ]
    }

export default routes
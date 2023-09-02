import TeacherList from "@/views/admin/teacher/TeacherList";
import TeacherAdd from "@/views/admin/teacher/TeacherAdd";
import TeacherUpdate from "@/views/admin/teacher/TeacherUpdate";
import TeacherIndex from "@/views/admin/teacher/TeacherIndex";

const routes=
        {
            path: '/admin/teacher',
            name:'teacherIndex',
            component:TeacherIndex,
            children:[
                {
                    path: 'list',
                    name: 'teacherList',
                    component:TeacherList
                },
                {
                    path: 'update',
                    name: 'teacherUpdate',
                    component:TeacherUpdate
                },
                {
                    path: 'add',
                    name: 'teacherAdd',
                    component:TeacherAdd
                }
            ]
        }







export default routes